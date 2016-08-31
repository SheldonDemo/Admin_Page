package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import entity.Admin;
import exception.PwdNullException;
import exception.PwdWrongException;
import exception.UserNotExistException;
import exception.UserNullException;
import exception.userRepeatException;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDao dao = new AdminDaoImpl();
	@Override
	public void addAdmin(Admin admin) throws userRepeatException, UserNullException, PwdNullException {

		if(admin.getUser().trim().equals("")){
			throw new UserNullException("�˻�������Ϊ��");
		}
		if(userExist(admin.getUser())){
			throw new userRepeatException("�˺��Ѵ���");
		}
		if(admin.getPwd().trim().equals("")){
			throw new PwdNullException("����������");
		}
		dao.addAdmin(admin);
	}

	@Override
	public void deleteAdmin(String user) {

		dao.deleteAdmin(user);
	}

	@Override
	public void updateAdmin(Admin admin) {

		dao.updateAdmin(admin);
	}

	@Override
	public boolean userExist(String user) {
		return dao.userExist(user);
	}

	@Override
	public Admin getAdmin(String user,String pwd) throws UserNullException, PwdNullException, UserNotExistException, PwdWrongException {

		if(user.trim().equals("")){
			throw new UserNullException("�˻�������Ϊ��");
		}
		if(pwd.trim().equals("")){
			throw new PwdNullException("����������");
		}
		if(!userExist(user)){
			throw new UserNotExistException("�˻���������ע��");
		}
		if(dao.getAdmin(user,pwd)==null){
			throw new PwdWrongException("�������");
		}
		return dao.getAdmin(user,pwd);
	}

	@Override
	public boolean userExist(Admin admin) {
		return dao.userExist(admin);
	}

}
