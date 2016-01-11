#encoding: utf-8
#!/usr/bin/python

def enum(**enums):
	return type('Enum',(),enums)