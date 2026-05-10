export interface CoinFlip {
  id: number;
  userChoice: string;
  outCome: string;
  winOrNo: boolean;
  timeFlippedAt: string;
  user: {
    id: number;
    name: string;
    email: string;
    role: string;
  };
}