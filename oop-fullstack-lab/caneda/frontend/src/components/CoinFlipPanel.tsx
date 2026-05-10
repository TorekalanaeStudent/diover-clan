import { useState, useEffect } from "react";
import type { User } from "../types/User";
import type { CoinFlip } from "../types/CoinFlip";
import { flipCoin, getFlipsByUser } from "../services/CoinFlipService";

interface Props {
  selectedUser: User | null;
}

const CoinFlipPanel = ({ selectedUser }: Props) => {
  const [flips, setFlips] = useState<CoinFlip[]>([]);
  const [flipping, setFlipping] = useState(false);
  const [lastResult, setLastResult] = useState<CoinFlip | null>(null);

  useEffect(() => {
    if (selectedUser?.id) {
      loadFlips(selectedUser.id);
    } else {
      setFlips([]);
      setLastResult(null);
    }
  }, [selectedUser]);

  const loadFlips = async (userId: number) => {
    const data = await getFlipsByUser(userId);
    setFlips(data);
  };

  const handleFlip = async (choice: string) => {
    if (!selectedUser?.id) return;
    setFlipping(true);
    setLastResult(null);
    try {
      const result = await flipCoin(selectedUser.id, choice);
      setLastResult(result);
      await loadFlips(selectedUser.id);
    } catch (error) {
      console.error(error);
    } finally {
      setFlipping(false);
    }
  };

  if (!selectedUser) {
    return (
      <div className="panel coin-panel empty-state">
        <div className="coin-empty">
          <div className="coin-icon">🪙</div>
          <p>Select a user to start flipping</p>
        </div>
      </div>
    );
  }

  const wins = flips.filter(f => f.winOrNo).length;
  const losses = flips.length - wins;

  return (
    <div className="panel coin-panel">
      <div className="panel-header">
        <h2>Coin Flip — {selectedUser.name}</h2>
        <div className="stats-row">
          <span className="stat win">✅ {wins} wins</span>
          <span className="stat loss">❌ {losses} losses</span>
        </div>
      </div>

      <div className="flip-area">
        {lastResult && (
          <div className={`result-badge ${lastResult.winOrNo ? "won" : "lost"}`}>
            <span className="result-coin">{lastResult.outCome === "heads" ? "👑" : "🔵"}</span>
            <span className="result-text">
              {lastResult.outCome.toUpperCase()} — You {lastResult.winOrNo ? "WON!" : "LOST"}
            </span>
          </div>
        )}

        <div className="flip-buttons">
          <button
            className={`flip-btn heads ${flipping ? "spinning" : ""}`}
            onClick={() => handleFlip("heads")}
            disabled={flipping}
          >
            👑 Heads
          </button>
          <button
            className={`flip-btn tails ${flipping ? "spinning" : ""}`}
            onClick={() => handleFlip("tails")}
            disabled={flipping}
          >
            🔵 Tails
          </button>
        </div>
        {flipping && <p className="flipping-text">Flipping...</p>}
      </div>

      <div className="flip-history">
        <h3>Flip History</h3>
        {flips.length === 0 && <p className="empty">No flips yet. Make your pick!</p>}
        <div className="history-list">
          {[...flips].reverse().map(flip => (
            <div key={flip.id} className={`history-row ${flip.winOrNo ? "win" : "loss"}`}>
              <span className="history-id">#{flip.id}</span>
              <span className="history-choice">Picked: <strong>{flip.userChoice}</strong></span>
              <span className="history-outcome">Result: <strong>{flip.outCome}</strong></span>
              <span className={`history-badge ${flip.winOrNo ? "won" : "lost"}`}>
                {flip.winOrNo ? "WIN" : "LOSS"}
              </span>
              <span className="history-time">{new Date(flip.timeFlippedAt).toLocaleTimeString()}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default CoinFlipPanel;
