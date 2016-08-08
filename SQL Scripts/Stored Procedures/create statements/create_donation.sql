CREATE OR REPLACE PROCEDURE create_donation 
(
	donation_id IN VARCHAR2,
	donor_id IN VARCHAR2,
	type_id	IN VARCHAR2,
	type IN VARCHAR2,
	amount IN FLOAT
) 
IS
BEGIN

	INSERT INTO Donations
	VALUES(donation_id, donor_id, type_id, type, amount);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'Donation ID already exists / duplicate id');

END create_donation;