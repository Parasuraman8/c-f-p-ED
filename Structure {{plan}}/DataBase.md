# DataBase ---> MySql 


# ........................Login information both user && edo && admin....................

--> username {{ Name }}
--> password {{ dob }}

note : it will generate form  when user new register both edo and user 

# ........................................................................................

# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> user's personal information <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

# .............................normal user information...................

UI

--> Name
--> Date of Brith
--> Qualification
--> address
--> mobile no 
--> gmail 
--> Job Start Date
--> job
--> job -- { role }
--> income per month
--> bank name
--> acct number 
--> religion
--> community
--> father name
--> gender
--> adhar number

# ........................ edo user information.........................

--> Name
--> Date of Brith
--> address
--> contact no 
--> gmail 
--> job
--> job -- { role }
--> age

# ......................admin user information..........................

--> Name
--> Date of Brith
--> address
--> contact no 
--> gmail 
--> age

# >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

# .........................................../ other information \.......................................................

# ''''''''''''''''user Bank information {{{foriegn key with user  name in perfonal info}}}'''''''''''''''''

--> bank name
--> acct number 
--> bank balnce
--> last debit amt
--> last credit amt
--> acct status
--> is salary recevied

# '''''''''''''''''''''user land information {{{foriegn key with user name in  perfonal info}}}''''''''''''''

--> land holder name 
--> land address
--> land date of register
--> land past holder name
--> how many arces
--> land type [ farming or plot or shop ] 
--> land status

# ..........................................................................................................................


# ............................................. transaction information...................................................

--> bank name
--> from acct no {{fetch by name as register in ED}}
--> to acct no {{fetch by name as register in ED}}
--> amount
--> remark
--> iscomplaint

# ''''''''''''''''''''''''''''''''''''''''''''''''''same as land register..........................
// above steps


# '''''''''''''''''''''''''''''''''''apeal information'''''''''''''''''''''''''''''''''''''''

--> sender name 
--> sender bank name
--> sender acct no
--> remark 
--> attempt 

# '''''''''''''''''''''''''''''''''''''''''''''payment && land recevie information'''''''''''''''''''''''''''''''

--> sender acct no
--> reveced acct no
--> amt


