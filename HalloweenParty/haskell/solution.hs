main :: IO()
main = do
  testCases <- getLine
  let
    numTestCases = read testCases::Int
  recur numTestCases

recur :: Int -> IO()
recur 0 = return ()
recur numTimesLeft = do
  curTestCase <- getLine
  let
    numCuts = read curTestCase::Int
    maximumNumberOfPieces = getMaximumNumberOfPieces numCuts
  putStrLn $ show maximumNumberOfPieces
  recur (numTimesLeft - 1)

getMaximumNumberOfPieces :: Int -> Int
getMaximumNumberOfPieces numCuts
  | numCuts `mod` 2 == 0 = halfCut * halfCut
  | otherwise = (halfCut + 1) * halfCut
  where halfCut = div numCuts 2
