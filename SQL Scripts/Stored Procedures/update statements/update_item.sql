CREATE OR REPLACE PROCEDURE update_item
(
	i_id IN VARCHAR2,
	i_name IN VARCHAR2,
	i_img IN VARCHAR2,
	i_donations IN FLOAT
) 
IS
BEGIN

	UPDATE Item
	SET name = i_name, img = i_img, total_donations = i_donations
	where item_id = i_id

	
EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'There was no data found');

END update_item;