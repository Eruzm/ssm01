insert into orders(client_id, amount, tran_date) values( 'F12345670', 100, datetime('now', 'localtime') );
insert into orders(client_id, amount, tran_date) values( 'F12345671', 200, datetime('now', 'localtime') );
insert into orders(client_id, amount, tran_date) values( 'F12345672', 250, datetime('now', 'localtime') );
insert into orders(client_id, amount, tran_date) values( 'F12345673', 300, datetime('now', 'localtime') );
insert into orders(client_id, amount, tran_date) values( 'F12345673', 300,datetime('now', 'localtime') );
insert into orders(client_id, amount, tran_date) values( 'F12345673', 500, datetime('now', 'localtime') );

select * from orders;


update orders 
set tran_date = datetime('now', 'localtime')
;