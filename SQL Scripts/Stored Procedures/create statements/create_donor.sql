CREATE OR REPLACE PROCEDURE create_donor 
(
	donor_id IN VARCHAR2,
	name IN VARCHAR2,
	email IN VARCHAR2
) 
IS
BEGIN

	INSERT INTO Donor
	VALUES(donor_id, name, email);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'Donor ID already exists / duplicate id');

END create_donor;