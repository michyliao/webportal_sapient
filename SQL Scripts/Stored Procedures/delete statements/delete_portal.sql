CREATE OR REPLACE PROCEDURE delete_portal
(
	p_id IN VARCHAR2
)
IS
BEGIN

	DELETE FROM Portal
	where portal_id = p_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_portal;