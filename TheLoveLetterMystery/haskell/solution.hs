import Data.List

main =  do
  tests <- getLine
  let
    numTestCases = read tests::Int
  loop 1 numTestCases
  
loop curIter numTestCases = do
  curWord <- getLine
  putStrLn $ show $ getCostOfPalindrome curWord
  if curIter == numTestCases || null curWord
     then return()
    else do
    loop (curIter+1) numTestCases

getCostOfPalindrome[] = 0
getCostOfPalindrome [_] = 0
getCostOfPalindrome word = foldl (\acc (x,y) -> acc + (getDifference x y)) 0 comparisons
                           where
                             lists = splitAt (((length word) + 1) `div` 2) word
                             comparisons = zip (fst lists) (reverse $ snd lists) 

getDifference char1 char2 = abs $ (index1 - index2)
                           where
                             index1 = 1 + (getValue $ elemIndex char1 alphabet)
                             index2 = 1 + ( getValue $ elemIndex char2 alphabet)
                             alphabet = ['a'..'z']
                             getValue maybeValue = case maybeValue of
                                                    Just value  -> value
                                                    Nothing -> 0

