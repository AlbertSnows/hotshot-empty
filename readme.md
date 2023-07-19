# Solving Hotshot

Repo to solve the hotshot problem per the request of the assessment.

Written in [clojurescript.](https://clojurescript.org/)

# Building

This project is built using the [shadow-cljs](https://github.com/thheller/shadow-cljs) framework.

Our application targets node. It's a simple CLI interface.

To build, make sure you have shadow-cljs and all other relevant packages (node, npm, etc.) [installed](https://shadow-cljs.github.io/docs/UsersGuide.html#_installation) via npx.

Then you can build a node script with the following command

`npx shadow-cljs release app`

or just

`shadow-cljs release app`

if you have `shadow-cljs` installed globally.

The production release targets the node file [/public/out/get-hotshot-score.js.](/public/out/get-hotshot-score.js)

Refer to [shadow-cljs.edn](./shadow-cljs.edn) for more information about how this repo is bulit.

Any hotshot data you want to test can be passed into this script. You can run it using the command

`node .\public\out\get-hotshot-score.js <input>`

An example use case is provided below.

```powershell
hotshot> node .\public\out\get-hotshot-score.js "{'body':
>>    [{
>>         'made_shots': ['green1', 'gray2', 'red2'],
>>         'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'blue2', 'red1', 'blue2', 'gray2', 'gray1', 'red2', 'blue1'],      
>>         'attempted_shots':  ['green1', 'yellow1', 'blue2', 'red1', 'blue2', 'gray2', 'gray1', 'red2', 'blue1'],
>>         'goat_shots': ['green1', 'yellow1', 'gray2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'blue2', 'red2'],
>>         'attempted_shots': ['green1', 'yellow1', 'blue2', 'red2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue2', 'red2']
>>     }, {
>>         'made_shots': ['red2', 'green1', 'blue1', 'red2', 'red1'],
>>         'attempted_shots': [ 'red2', 'green1', 'blue1', 'red2' ,'red1', 'green1']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red1'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red1']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'gray2'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'gray2', 'blue2'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue2']
>>     }, {
>>         'made_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2'],
>>         'attempted_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2']}]}"
[9 21 56 68 75 75 90 100 114 129]
```
