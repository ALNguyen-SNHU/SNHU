# Example Python Code to Insert a Document 

from pymongo import MongoClient 
from bson.objectid import ObjectId 

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self): 
        # Initializing the MongoClient. This helps to access the MongoDB 
        # databases and collections. This is hard-wired to use the aac 
        # database, the animals collection, and the aac user. 
        # 
        # You must edit the password below for your environment. 
        # 
        # Connection Variables 
        # 
        USER = 'aacuser' 
        # PASS = 'SNHU1234'
        PASS = 'root'
        HOST = 'localhost' 
        PORT = 27017 
        DB = 'aac' 
        COL = 'animals' 
        # 
        # Initialize Connection 
        # 
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT)) 
        self.database = self.client['%s' % (DB)] 
        self.collection = self.database['%s' % (COL)] 

    # Create a method to return the next available record number for use in the create method
            
    # Complete this create method to implement the C in CRUD. 
    def create(self, document):
        if document is not None:                       # Data existent check
            try:
                self.collection.insert_one(document)   # Data insertion
                return True                        # True boolean returns if successful
            except Exception as e:                 # In the case the data is malformed, the database goes down, or connection is cut during the process...
                print("Display Insertion Error Message...", e)                 # Error message displayed instead of crashing
                return False                       # False boolean returns instead of crash
        else:
            return False                           # False boolean returns if no data provided
            # self.database.animals.insert_one(data)  # data should be dictionary             
        # else: 
            # raise Exception("Nothing to save, because data parameter is empty") 

    # Create method to implement the R in CRUD.
    def read(self, query):
        if query is not None:                        # Check existent of query
            try:
                cursor = self.collection.find(query) # Query MongoDB using find function
                return list(cursor)                 # Convert cursor to list and return
            # Same as the create function, if the query is malformed, the database goes down, or the connection dies...
            except Exception as e:
                print("Display Query Error Message...", e)
                return []                            # Return empty list
        else:
            return []                                # Return empty list
                