CREATE OR REPLACE PROCEDURE create_portal 
(
	portal_id IN VARCHAR2,
	name IN VARCHAR2
)	
IS
BEGIN

	INSERT INTO Portal
	VALUES(portal_id, name, 0.00);

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	RAISE_APPLICATION_ERROR(-1, 'Portal ID already exists / duplicate id');

END create_portal;