package data;

import models.ManagerInfo;

public interface ManagerRepository extends Repository<Integer,ManagerInfo> {
    ManagerInfo findUserName(String userName);
}
