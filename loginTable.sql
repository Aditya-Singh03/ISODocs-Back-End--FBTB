CREATE TABLE LOGIN_INFO(	
	USER_NAME varChar(50) not NULL, --primary key
	HASH_PASS varChar(50) not NULL
);
INSERT INTO LOGIN_INFO VALUES
('user1','password123'),
('icescream320','i_scr3am'),
('John@Doe','JaNeDoE');
select*
from LOGIN_INFO