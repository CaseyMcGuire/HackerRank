main :: IO()
main = do
  testCases <- getLine
  let
    numTestCases = read (head $ words testCases)::Int
  printWhetherClassCanceled numTestCases

printWhetherClassCanceled :: Int -> IO()
printWhetherClassCanceled 0 = return ()
printWhetherClassCanceled curIter = do
  firstLine <- getLine
  secondLine <- getLine
  let
    threshold = read (last . words $ firstLine)::Int
    studentEnterTimes = map (\x -> read x::Int) $ words secondLine
    numStudentsOnTime = length $ filter (<=0) studentEnterTimes
  if (numStudentsOnTime < threshold)
    then do putStrLn  "YES"
    else do putStrLn "NO"
  printWhetherClassCanceled (curIter - 1)
     
