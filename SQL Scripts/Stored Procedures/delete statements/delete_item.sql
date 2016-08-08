CREATE OR REPLACE PROCEDURE delete_item 
(
	i_id IN VARCHAR2
)
IS
BEGIN

	DELETE FROM Item
	where item_id = i_id;

EXCEPTION
	WHEN NO_DATA_FOUND THEN
	RAISE_APPLICATION_ERROR(-1, 'ID does not exist');

END delete_item;