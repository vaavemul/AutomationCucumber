Feature: Searching the product
@Search
Scenario:Verify the product names

Given User is on the landing page
When User searched with shortname <Name> and extracted the name
When User navigates to offers page and get the product name <Name>
Then Verify the prod name and offer name matches

Examples:
 | Name |
 | tom  |
 | beet |
