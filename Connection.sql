select * from task where not status='ARCH';
INSERT INTO task (id, owner, text, date, status) VALUES ('9', 'user','��� 3','wed','WAIT');
select * from task;