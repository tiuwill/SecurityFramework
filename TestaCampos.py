#!/usr/bin/python
import sys
import re
from mechanize import Browser


url = sys.argv[1];
br = Browser()
br.open(url)
br.select_form(nr=0)
i = 2;
while i < len(sys.argv):
	br[sys.argv[i]] = sys.argv[i+1]
	i=i+2; 

response = br.submit()
print response.geturl()
print response.read()
