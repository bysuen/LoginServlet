package service;

import dao.UsercheckDao;

public class CheckService {
    public boolean checkname(String name){
        UsercheckDao dao = new UsercheckDao();
        Long isExist = dao.checkusername(name);

        return isExist>0?true:false;
    }
}
