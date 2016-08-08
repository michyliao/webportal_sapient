CREATE OR REPLACE PROCEDURE findALL_items
(
	item_cursor out SYS_REFCURSOR
)
IS
BEGIN
	
	OPEN item_cursor FOR
		SELECT item_id, Item.project_id, Item.name, img, Item.total_donation
		FROM Item 
		Inner Join Project p on p.project_id = Item.project_id;

END findALL_items;