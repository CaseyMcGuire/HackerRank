import Data.List

main :: IO()
main = do
  dimensions <- getLine
  let numDimensions = read dimensions::Int
  matrix <- sequence [getLine | _ <- [1..numDimensions]]
  let convertedMatrix = map (\x -> map (\y -> read y::Int) x) $ map words matrix
  print $ getDiagonalSum convertedMatrix
  return ()

getDiagonalSum :: [[Int]] -> Int
getDiagonalSum matrix = abs (leftToRightDiagonalSum matrix - (leftToRightDiagonalSum . reverse) matrix)
  
leftToRightDiagonalSum :: [[Int]] -> Int
leftToRightDiagonalSum matrix = fst $ foldl' (\(acc,index) x -> (acc + (x !! index), index + 1)) (0,0) matrix

  
