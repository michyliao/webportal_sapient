CREATE OR REPLACE PROCEDURE findAll_donationsItem
(
	donation_cursor out SYS_REFCURSOR
)
IS
BEGIN

    OPEN donation_cursor FOR 
	    SELECT donation_id, donor_id, type_id, type, amount  
		FROM Donations
		where type='Item';

END findAll_donationsItem;


