CREATE OR REPLACE PROCEDURE find_portal
(
	portal_name IN Portal.name%TYPE,

	out_id OUT Portal.portal_id%TYPE,
	out_name OUT Portal.name%TYPE,
	out_total_donation OUT Portal.total_donation%TYPE		
) 
IS
BEGIN

	select portal_id, name, total_donation
	into out_id, out_name, out_total_donation
	from portal
	where name = portal_name;

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_portal;