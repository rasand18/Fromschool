def top_note(dicta):
   dicta["notes"]= max(dicta["notes"])
   dicta["top_notes"] = dicta.pop("notes")
   print(dicta)
 

top_note({ "name": "John", "notes": [3, 5, 4] })