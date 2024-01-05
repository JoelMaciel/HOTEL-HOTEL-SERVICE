set foreign_key_checks = 0;

delete from hotels;

set foreign_key_checks = 1;


INSERT INTO hotels (hotel_id, name, location, information)
VALUES
  ('30f7892b-5231-4683-99c3-841ad07aee70' , 'Hotel One', 'City A', 'Luxurious hotel in the heart of City A.'),
  ('c20e7321-7fda-403f-aee4-f802c908087d' , 'Hotel Two', 'City B', 'Scenic hotel with a beautiful view in City B.'),
  ('62d75897-755d-40d1-9600-5841a68d99fc' , 'Hotel Three', 'City C', 'Cozy hotel nestled in the quiet surroundings of City C.');


