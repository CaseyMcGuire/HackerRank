
main :: IO()
main = do
  _ <- getLine 
  sticksLine <- getLine
  let
    sticks = map (\x -> read x::Int) (words sticksLine)
  printNumSticksCut sticks

printNumSticksCut :: [Int] -> IO()
printNumSticksCut [] = return ()
printNumSticksCut list = do
  putStrLn $ show (length list)
  let
    smallestStick = minimum list
    cutSticks = filter (>0) $ map (subtract smallestStick) list
  printNumSticksCut cutSticks
