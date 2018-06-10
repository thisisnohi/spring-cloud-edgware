insert into user (id, username , password , age , birthday)
values (1,'Tom','tom',12 , parsedatetime('1991-09-17 11:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS'));
insert into user (id, username , password , age , birthday)
values (2,'Jerry','jerry', 23 ,parsedatetime('1992-09-17 1:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS'));
insert into user (id, username , password , age , birthday)
values (3,'Reno','reno', 44,parsedatetime('1993-09-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS'));
insert into user (id, username , password , age , birthday)
values (4,'Josh', 'josh',55,{ts '1994-09-17 22:47:52.69'});