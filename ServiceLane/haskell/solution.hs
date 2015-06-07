
main =  do
  firstLine <- getLine
  widthOfEachSegment <- getLine
  let
    wordsOfFirstLine = words firstLine
    lengthOfFreeway = read (head wordsOfFirstLine)::Int
    numberOfTestCases = read (last wordsOfFirstLine)::Int
    width = map (\x -> read x::Int) $ words widthOfEachSegment
  loop 1 numberOfTestCases lengthOfFreeway width


loop curIter numTestCases lengthOfFreeway width = do
  line <- getLine
  let
    curLine = words line
    i = read (head curLine)::Int
    j = read (last curLine)::Int
  putStrLn $ show $ minimum $ sublist width i (j+1)
  if null line || curIter == numTestCases
    then do
    return ()
    else do
    loop (curIter + 1) numTestCases lengthOfFreeway width

--Returns a sublist of the passed list  starting at thestart parameter  and ending at the end parameter,
--exclusive
sublist :: [a] -> Int -> Int -> [a]
sublist list start end = drop start . take end $ list
