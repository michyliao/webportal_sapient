CREATE OR REPLACE PROCEDURE findALL_portals
(
	portal_cursor out SYS_REFCURSOR
)
IS
BEGIN

	OPEN portal_cursor FOR
		SELECT portal_id, name 
		FROM Portal;

END findALL_portals;