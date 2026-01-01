from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

print(">>> STARTING ML SERVICE <<<")

# Load trained model
model = joblib.load("water_quality_model.pkl")

def wqi_label(wqi):
    if wqi >= 75:
        return "Good"
    elif wqi >= 50:
        return "Moderate"
    else:
        return "Poor"

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json(force=True)

    features = np.array([[
        data["temperature"],
        data["turbidity"],
        data["ph"],
        data["doValue"],
        data["bod"],
        data["cod"],
        data["nitrate"],
        data["phosphate"],
        data["tds"],
        data["conductivity"],
        data["fecal_coliform"]
    ]])

    wqi = model.predict(features)[0]

    return jsonify({
        "WQI": round(float(wqi), 2),
        "quality": wqi_label(wqi)
    })

@app.route("/", methods=["GET"])
def home():
    return "ML Service is running"

if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000, debug=False)



