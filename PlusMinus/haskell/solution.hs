import Data.List
import Text.Printf

main :: IO()
main = do
  getLine
  line <- fmap ((map words) . lines) getContents
  let nums = map (\x -> read x::Int) (head line)
  mapM_ (printf "%.3f\n") $ getFraction (length nums) $ accumulate nums
  return ()

getFraction :: Int -> (Int,Int,Int) -> [Float]
getFraction length (x,y,z) = [x'/length', y'/length', z'/length']
  where
    x' = fromIntegral x
    y' = fromIntegral y
    z' = fromIntegral z
    length' = fromIntegral length

accumulate :: [Int] -> (Int, Int, Int)
accumulate lst = foldl' (getTuple) (0,0,0) lst
                 where
                   getTuple (i,j,k) x
                     | x > 0 = (i+1,j,k)
                     | x < 0 = (i,j+1,k)
                     | otherwise = (i,j,k+1)

