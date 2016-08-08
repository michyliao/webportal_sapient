CREATE OR REPLACE PROCEDURE update_donation
(
	d_id IN VARCHAR2,
	d_donor_id IN VARCHAR2,
	d_type_id IN VARCHAR2,
	d_type IN VARCHAR2,
	d_amount IN FLOAT	
) 
IS
BEGIN

	UPDATE Donations
	SET donor_id = d_donor_id, type_id = d_type_id, type = d_type, amount = d_amount
	where donation_id = d_id

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_donation;