################USER Creation##########################
CREATE TABLE public.users
(
  user_id bigint NOT NULL,
  username character varying(50),
  password text NOT NULL,
  firstname character varying(50) NOT NULL,
  lastname character varying(50) NOT NULL,
  email_id character varying(50),
  mobile_no character varying(11),
  gender_id smallint,
  role_id integer NOT NULL,
  temp_block bit(1),
  tempblock_date timestamp(3) without time zone,
  block bit(1),
  blocked_date timestamp(3) without time zone,
  password_change_flag integer,
  password_change_date timestamp(3) without time zone,
  add_user integer DEFAULT 1,
  last_logged_in timestamp(3) without time zone DEFAULT now(),
  added_date timestamp(3) without time zone DEFAULT now(),
  issid integer NOT NULL DEFAULT nextval('users_issid_seq'::regclass),
  id bigint
)
#################FOOD########################
CREATE TABLE public.food
(
  id bigint,
  hotel character varying(50),
  food_name character varying(50) NOT NULL,
  food_type character varying(50) NOT NULL,
  food_description character varying(255) NOT NULL,
  prize character varying(6) NOT NULL,
  is_available boolean NOT NULL
)
CREATE TABLE public.orders
(
  id bigint NOT NULL,
  customername character varying(20) NOT NULL
)
################################Pages##################################

CREATE TABLE public.pages
(
  pageid bigint NOT NULL,
  pagename character varying(100),
  pageurl character varying(250),
  parentid integer,
  orderno integer,
  levelno integer,
  deleteflag bit(1) DEFAULT false,
  addeddate timestamp(3) without time zone DEFAULT now(),
  lastupdateddate timestamp without time zone,
  deletedby integer,
  deletedate timestamp without time zone,
  issid integer NOT NULL DEFAULT nextval('pages_issid_seq'::regclass)
)

CREATE TABLE public.rolepages
(
  roleid integer NOT NULL,
  pageid integer NOT NULL,
  adduser integer,
  addeddate timestamp without time zone,
  issid integer NOT NULL DEFAULT nextval('rolepages_issid_seq'::regclass)
)
CREATE TABLE public.roles
(
  roleid bigint NOT NULL,
  rolename character varying(50) NOT NULL,
  roledescription character varying(500),
  adduser integer NOT NULL,
  addeddate timestamp(3) without time zone DEFAULT now(),
  issid integer NOT NULL DEFAULT nextval('roles_issid_seq'::regclass),
  id bigint
)

CREATE TABLE public.todo
(
  id bigint NOT NULL,
  description character varying(255),
  is_done boolean NOT NULL,
  target_date timestamp without time zone,
  username character varying(255),
  CONSTRAINT todo_pkey PRIMARY KEY (id)
)