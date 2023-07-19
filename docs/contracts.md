# Ingested API JSON

```json
{[
    # Round 1
    {
        'made_shots': ['green1', 'gray2', 'red2'],
        'attempted_shots': ['green1', 'gray2', 'blue2', 'red2']

    },
    # Round 2
    {
        'made_shots': ['green1', 'yellow1', 'gray2', 'blue1'],
        'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
    },
    # Round 3
    {
        'made_shots': ['green1', 'yellow1', 'blue2', 'red1', 'blue2', 'gray2', 'gray1', ’red2’, 'blue1'],
        'attempted_shots':  ['green1', 'yellow1', 'blue2', 'red1', 'blue2', 'gray2', 'gray1', ’red2’, 'blue1'],
        'made_bonus_shots': ['green1', 'yellow1', 'gray2']
    },
    # Round 4
    {
        'made_shots': ['green1', 'yellow1', 'blue2', 'red2'],
        'attempted_shots': ['green1', 'yellow1', 'blue2', 'red2']
    },
    # Round 5
    {
        'made_shots': ['green1', 'yellow1'],
        'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue2', 'red2']
    },
    # Round 6
    {
        'made_shots': ['red2', 'green1', 'blue1' 'red2' 'red1'],
        'attempted_shots': [ 'red2', 'green1', 'blue1', 'red2' ,'red1', 'green1']
    
    # Round 7
    {
        'made_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red1'],
        'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red1']
    },
    # Round 8
    {
        'made_shots': ['green1', 'yellow1', 'gray2'],
        'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue1', 'red2']
    },
    # Round 9
    {
        'made_shots': ['green1', 'yellow1', 'gray2', 'blue2'],
        'attempted_shots': ['green1', 'yellow1', 'gray2', 'blue2']
    },
    # Round 10 (Final Round)
    {
        'made_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2'],
        'attempted_shots': ['green1', 'yellow1', 'gray1', 'blue2', 'red2'],
    },
]}
```

## Expected Output

scorecard = [9, 21, 56, 68, 75, 75, 90, 100, 114, 129]
