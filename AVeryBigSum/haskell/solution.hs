main :: IO()
main = do
  _ <- getLine
  numsToAdd <- getLine
  let bigSum = sum $ map (\x -> read x::Int) $ words numsToAdd
  print bigSum
