ALTER TABLE Donations
add constraint type CHECK
(type in ('Project', 'Portal', 'Item'));


ALTER TABLE Donations
add constraint amount CHECK
(amount > 0.00);

ALTER TABLE Project
add constraint cost CHECK
(cost >= 0.00);

