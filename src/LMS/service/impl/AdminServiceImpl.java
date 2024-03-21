package LMS.service.impl;

import LMS.db.Datebase;
import LMS.model.Admin;
import LMS.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public String register(Admin admin) {
        for (Admin admin1 : Datebase.getAdmin) {
            admin1.setEmail(admin.getEmail());
            admin1.setPassword(admin.getPassword());

        }
        return "Сиз ийгиликтуу регистрациядан отуунуз ";
    }
    }

