import sys
import json
import numpy as np

def predict_wqi(data):
    # TEMP: use same logic/value you already use
    # (later we’ll plug real model here)
    wqi = round(
        100
        - data["turbidity"] * 5
        - data["bod"] * 3
        - data["cod"] * 1
        - data["fecal_coliform"] * 0.5,
        2
    )

    if wqi >= 80:
        quality = "Good"
    elif wqi >= 50:
        quality = "Moderate"
    else:
        quality = "Poor"

    return {"wqi": wqi, "quality": quality}


if __name__ == "__main__":
    input_json = sys.argv[1]
    data = json.loads(input_json)

    result = predict_wqi(data)
    print(json.dumps(result))
