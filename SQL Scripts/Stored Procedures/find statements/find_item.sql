CREATE OR REPLACE PROCEDURE find_item 
(
	item_name IN Item.name%TYPE,
	project_name IN Project.name%TYPE,

	out_id OUT Item.item_id%TYPE,	
	out_name OUT Item.name%TYPE,
	out_img OUT Item.img%TYPE,
	out_total_donation OUT Item.total_donation%TYPE		
) 
IS
BEGIN

	select i.item_id, i.name, i.img, i.total_donation 
	into out_id, out_name, out_img, out_total_donation
	from item i 
	inner join project p on p.project_id = i.project_id
	where (p.name = project_name) or (i.name = item_name);


	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END find_item;