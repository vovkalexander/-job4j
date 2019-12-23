  CREATE TABLE items
(
  id_items serial primary key not null,
  names character varying(100),
  description character varying(100),
  created bigint
  );