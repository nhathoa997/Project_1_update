insert into role (name) values
    ('tech-manager'), ('lead-trainer'), ('senior-trainer'), ('trainer'),
    ('qc-coordinator'), ('qc-lead'), ('qc');

insert into employee (email, first_name, last_name, password, dept)
    values ('steven.kelsey@revature.com', 'Steven', 'Kelsey', 'password123', 'TRAINING'),
           ('august.duet@revature.com', 'August', 'Duet', '123password', 'TRAINING'),
           ('andrew.crenwelge@revature.com', 'Andrew', 'Crenwelge', 'p@$$w0rd', 'QC'),
           ('kevin.tranhuu@revature.com', 'Kevin', 'Tran Huu', 'p@$$w0rd123', 'QC');

insert into employee_role (emp_id, role_id) values
    (1, 1), (2,2), (3,5), (4, 6);