using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEditor.SearchService;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.WSA;

namespace JervNorsk.Tool.GeometryNode.Mesh.Primitive
{
    [CustomEditor(typeof(Grid))]
    public class GridEditor : Editor
    {
        public override void OnInspectorGUI()
        {
            DrawDefaultInspector();

            var rawTarget = target as Grid;

            if (GUILayout.Button("Update"))
            {
                rawTarget.FixedUpdate();
            }
        }

        internal class Menu
        {

            [MenuItem("GameObject/Geometry Nodes/Mesh Primitives/Grid")]
            private static void CreateGameObject()
            {
                Grid.CreateGameObject();
            }
        }
    }
}