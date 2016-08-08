CREATE OR REPLACE PROCEDURE find_donor
(
	donor_name IN Donor.name%TYPE,
	donor_email IN Donor.email%TYPE,
	out_id OUT Donor.donor_id%type,
	out_name OUT Donor.name%TYPE,
	out_email OUT Donor.email%TYPE
) 
IS
BEGIN

	select donor_id, name, email 
	INTO out_id, out_name, out_email
	from Donor
	where name = donor_name or email = donor_name;

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_donor;