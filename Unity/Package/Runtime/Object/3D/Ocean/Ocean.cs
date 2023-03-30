using Codice.CM.Client.Differences.Graphic;
using JervNorsk.Tool.Util.Collection;
using System.Collections;
using System.Collections.Generic;
using System.Drawing;
using UnityEditor;
using UnityEngine;
using UnityEngine.UIElements;

namespace JervNorsk.Tool.Object3D
{
    public class Ocean : MonoBehaviour
    {
        public int size;

        [HideInInspector]
        public GridList<OceanTile> tileList;
        public int tileSize;

        private void InitAttributes()
        {
            if (size == 0)
            {
                size = 4;
            }
        }

        private void InitTiles()
        {
            if (tileList == null)
            {
                tileList = new GridList<OceanTile>();

                foreach (var childTile in gameObject.GetComponentsInChildren<OceanTile>())
                {
                    tileList.Add(childTile);
                }
            }
            else
            {
                ClearTiles(tileList.Count);
            }
            InitTileAttributes();

        }

        private void InitTileAttributes()
        {
            if (tileSize == 0)
            {
                tileSize = 1;
            }
        }

        private void UpdateAttributes()
        {

        }

        private void UpdateTiles()
        {
            int requiredTileCount = Mathf.CeilToInt((float)size / tileSize);
            int requiredTileCountDelta = (tileList.Count - requiredTileCount) * -1;

            if (requiredTileCountDelta > 0)
            {
                CreateTiles(requiredTileCountDelta);
            }
            else if (requiredTileCountDelta < 0)
            {
                ClearTiles(requiredTileCountDelta * -1);
            }
        }

        private void CreateTiles(int tileCountDelta)
        {
            for (int i = 0; i < tileCountDelta; i++)
            {
                var tileGameObject = OceanTile.CreateGameObject(this);
                var tileScript = tileGameObject.GetComponent<OceanTile>();

                tileList.Add(tileScript);
            }
        }

        private void ClearTiles(int tileCountDelta)
        {
            for (int i = 0; i < tileCountDelta; i++)
            {
                var tile = tileList[^1];

                tileList.RemoveAt(tileList.Count - 1);

#if UNITY_EDITOR
                DestroyImmediate(tile.gameObject);
#else
                Destroy(tile.gameObject);
#endif
            }
        }

        public static GameObject CreateGameObject()
        {
            return new GameObject();
        }

        public void Start()
        {
            Debug.Log("Start");

            Reset();
        }

        public void Reset()
        {
            Debug.Log("Reset");

            InitAttributes();
            InitTiles();
        }

        public void FixedUpdate()
        {
            Debug.Log("FixedUpdate");

            UpdateAttributes();
            UpdateTiles();
        }
    }
}