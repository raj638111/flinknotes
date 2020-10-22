

-- Join Hint

  Example: d1.join(d2, JoinHint.OPTIMIZER_CHOOSES)

  + Available Hints
    1. OPTIMIZER_CHOOSES
    2. BROADCAST_HASH_FIRST
       (Broadcast the first dataset(if 1st dataset is small). This is basically Broadcast join)
    3. BROADCAST_HASH_SECOND
    ...
    8. ...