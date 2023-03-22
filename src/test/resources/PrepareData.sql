insert into owner (id, owner) values ('1', 'user');
truncate table task;
insert into task (id, owner_id, text, date, status) values ('3', '1','помидоры (tomatoes)','Wed Mar 25 16:01','WAIT');
insert into task (id, owner_id, text, date, status) values ('11', '1','гречка (buckwheat)','Wed Mar 24 16:01','WAIT');
insert into task (id, owner_id, text, date, status) values ('14', '1','картошка (potatoes)','Thu Mar 23 16:01','DONE');

