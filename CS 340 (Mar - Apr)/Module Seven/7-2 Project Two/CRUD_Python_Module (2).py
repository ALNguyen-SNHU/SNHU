# Example Python Code to Insert a Document 

from pymongo import MongoClient 
from bson.objectid import ObjectId 

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self, username, password): 
        # Initializing the MongoClient. This helps to access the MongoDB 
        # databases and collections. This is hard-wired to use the aac 
        # database, the animals collection, and the aac user. 
        # 
        # You must edit the password below for your environment. 
        # 
        # Connection Variables 
        # 
        # USER = 'aacuser'
        USER = username
        # PASS = 'SNHU1234'
        # PASS = 'root'
        # password = PASS
        PASS = password
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
        
    # Create method to update the ? in CRUD.
    def update(self, query, values):
        if query is not None and values is not None:                             # So long as there is a value and you can query it, because you can't update something that does not exist...
            try:
                response = self.collection.update_many(query, {"$set": values})  # From the animal collection, filter query input for documents, and set new values
                return response.modified_count                                   # Return amount of documents modified in the process.
                # pass
            except Exception as e:                                               # In the case antying happens to the MongoDB, corruption in the query format, or unprocessable values...
                # pass
                print("Display Update Error Message...", e)                      # Error messages
                return 0
        # Cannot update something that does not exist. Return 0
        else:
            return 0
            
    # Create method to delete the ? in CRUD.
    def delete(self, query):
        if query is not None:                                                    # So long as what you're looking for actually exists...
            try:
                erasure = self.collection.delete_many(query)                     # Return amount of documents deleted in the process.
                return erasure.deleted_count
            except Exception as e:                                               # In the case that anything happens to the MongoDB or corruption in query format...
                print("Display Erasure Error Message...", e)                     # Display error message
                return 0
        # Cannot delete something that does not exist. Return 0.
        else:
            return 0