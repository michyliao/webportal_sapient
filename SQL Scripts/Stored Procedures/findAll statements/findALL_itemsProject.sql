CREATE OR REPLACE PROCEDURE findALL_itemsProject
(
	proj_id IN Project.project_id%TYPE,
	project_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN project_cursor FOR
		SELECT item_id, Item.project_id, Item.name, img, Item.total_donation
		FROM Item 
		where project_id=proj_id;

END findALL_itemsProject;