CREATE OR REPLACE PROCEDURE update_portal
(
	p_id IN VARCHAR2,
	p_name IN VARCHAR2		
) 
IS
BEGIN

	UPDATE Portal
	SET name = p_name
	where portal_id = p_id

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_portal;